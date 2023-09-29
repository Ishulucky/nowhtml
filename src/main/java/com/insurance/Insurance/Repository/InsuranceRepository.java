package com.insurance.Insurance.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.Insurance.contracts.InsuranceDAO;
import com.insurance.Insurance.model.CustomerData;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicySchedule;

@Repository
public class InsuranceRepository {
	@Autowired
	private InsuranceDAO insuranceDAO;

	public List<InsurancePolicy> ListAllPolicy() {
		List<InsurancePolicy> pack = insuranceDAO.getAllPolicies();
		return pack;
	}

	public List<InsurancePolicySchedule> ListAllPolicySchedules() {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllSchedule();
		return s;
	}

	public List<InsurancePolicySchedule> ListAllPolicySchedulesById(int id) {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllScheduleById(id);
		return s;
	}

	public int createNewPolicy(InsurancePolicy u) {
		return insuranceDAO.addPolicy(u);
	}

	public int createCustomer(CustomerData u) {
		return insuranceDAO.addCustomer(u);
	}

	public int updateNewPolicy(InsurancePolicy u) {
		return insuranceDAO.updateStatus(u);
	}

	public InsurancePolicy getPolicyeById(int id) {
		return insuranceDAO.getPolicyById(id);
	}

	public int ListNonStatusPayments(int id) {
		return insuranceDAO.getNonPaymentStatus(id);
	}

	public List<Integer> findDistinctIds() {
		return insuranceDAO.findDistinctIplcIds();
	}

}
