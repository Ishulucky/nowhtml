package com.insurance.Insurance.contracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insurance.Insurance.model.CustomerData;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicyRowMapper;
import com.insurance.Insurance.model.InsurancePolicySchedule;
import com.insurance.Insurance.model.InsurancePolicyScheduleRowMapper;

@Repository
public class InsuranceDAOImplement implements InsuranceDAO {
	private final JdbcTemplate jdbctemplate;

	@Autowired
	public InsuranceDAOImplement(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public List<InsurancePolicy> getAllPolicies() {
		String sql = "SELECT * FROM InsurancePolicies1";
		return jdbctemplate.query(sql, new InsurancePolicyRowMapper());
	}

	@Override
	public List<InsurancePolicySchedule> getAllSchedule() {
		String sql = "SELECT * FROM InsurancePolicySchedule";
		return jdbctemplate.query(sql, new InsurancePolicyScheduleRowMapper());
	}

	@Override
	public List<InsurancePolicySchedule> getAllScheduleById(int id) {
		String sql = "select * from InsurancePolicySchedule where iplc_id=?";
		return jdbctemplate.query(sql, new InsurancePolicyScheduleRowMapper(), new Object[] { id });
	}

	@Override
	public int addPolicy(InsurancePolicy e) {
		return jdbctemplate.update(
				"INSERT INTO InsurancePolicies1 (iplc_cust_id, iplc_cdate, iplc_sum_assured, iplc_applicable_date, iplc_nom_insured, iplc_insp_id, iplc_yrly_prem_amount, iplc_paymode_count, iplc_expdate, iplc_agnt_id) VALUES (?,current_date, ?, CURRENT_DATE+INTERVAL '1 MONTH', ?, ?, ?, ?,  CURRENT_DATE+INTERVAL '13 MONTH', ?)",
				e.getIplc_cust_id(), e.getIplc_sum_assured(), e.getIplc_nom_insured(), e.getIplc_insp_id(),
				e.getIplc_yrly_prem_amount(), e.getIplc_paymode_count(), e.getIplc_agnt_id());
	}

	@Override
	public int addCustomer(CustomerData e) {
		return jdbctemplate.update(
				"INSERT INTO customers (cust_fname, cust_lname, cust_dob, cust_address, cust_gender, cust_cdate, cust_aadhar, cust_status, cust_luudate, cust_luuser, cust_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, current_date, 1, 1)",
				e.getCust_fname(), e.getCust_lname(), e.getCust_dob(), e.getCust_address(), e.getCust_gender(),
				e.getCust_cdate(), e.getCust_aadhar(), e.getCust_status());
	}

	@Override
	public int updateStatus(InsurancePolicy e) {
		return jdbctemplate.update("UPDATE InsurancePolicies1 SET iplc_status = ? WHERE iplc_id = ?",
				e.getIplc_status(), e.getIplc_id());

	}

	@Override
	public InsurancePolicy getPolicyById(int id) {
		String stmt = "SELECT * FROM InsurancePolicies1 WHERE iplc_id = ?";
		return jdbctemplate.queryForObject(stmt, new InsurancePolicyRowMapper(), new Object[] { id });
	}

	@Override
	public int getNonPaymentStatus(int id) {
		try {
			String sql = "SELECT COUNT(*) FROM InsurancePolicySchedule WHERE CURRENT_DATE >= iplc_date AND iplc_paid_date IS NULL AND iplc_id = ?";
			return jdbctemplate.queryForObject(sql, Integer.class, id);
		} catch (EmptyResultDataAccessException e) {
			// Handle the case where no results are found
			return 0; // or throw an exception or handle it as needed
		}
	}

	@Override
	public List<Integer> findDistinctIplcIds() {
		String sql = "SELECT DISTINCT iplc_id FROM InsurancePolicySchedule";
		return jdbctemplate.queryForList(sql, Integer.class);
	}

}
