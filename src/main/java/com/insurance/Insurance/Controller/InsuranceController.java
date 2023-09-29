package com.insurance.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.Insurance.Repository.InsuranceRepository;
import com.insurance.Insurance.model.InsurancePolicy;

@Controller
public class InsuranceController {
	@Autowired
	private InsuranceRepository insu;

	// to view PolicyHomePage
	@GetMapping("/policyHomePage")
	public String getAllLinks() {
		return "Links";
	}

	// To view Applied Policies
	@GetMapping("/getPolicy")
	public String getAllPolicy(Model m) {
		List<InsurancePolicy> p = insu.ListAllPolicy();
		m.addAttribute("policies", p);
		return "ViewPolicy";
	}

	// To view schedule of all members at insurance side
	@GetMapping("/getpolicySchedule")
	public String getAllPolicySchedule(Model m) {
		m.addAttribute("schedules", insu.ListAllPolicySchedules());
		return "ViewSchedule";
	}

	// Used for Status Approval
	@GetMapping("/updatePolicy")
	public String UpdateFormPolicy(Model m) {
		List<InsurancePolicy> p = insu.ListAllPolicy();
		m.addAttribute("policies", p);
		return "StatusApproval";
	}

	// Used for change status of a policy
	@GetMapping("/updateStatusPolicy")
	public String updatedversionPolicy(@ModelAttribute("policy") InsurancePolicy policy) {
		insu.updateNewPolicy(policy);

		return "redirect:/getpolicy";
	}

	// Used to Know how many months the customer does not paid the policy for a particular id
	@GetMapping("/nonPaymentStatus")
	public String getNonPaymentStatus(@RequestParam("iplcId") int id, Model m) {
		int p = insu.ListNonStatusPayments(id);
		m.addAttribute("policies", p);
		return "ViewNonPaymentStatus";

	}

	// Used for distinct policy id for the
	@GetMapping("/StatusPaymentById")
	public String getDistinctIplcIds(Model model) {
		List<Integer> distinctIplcIds = insu.findDistinctIds();
		model.addAttribute("distinctIplcIds", distinctIplcIds);
		return "StatusById";
	}

	// Used for distinct policy id for viewing Schedule
	@GetMapping("/ScheduleById")
	public String getScheduleDistinctIplcIds(Model model) {
		List<Integer> distinctIplcIds = insu.findDistinctIds();
		model.addAttribute("distinctIplcIds", distinctIplcIds);
		return "ViewScheduleById";
	}

	// Used to view Schedule of a particular policy id
	@GetMapping("/getpolicyScheduleById")
	public String getAllPolicyScheduleById(@RequestParam("iplcId") int id, Model m) {
		m.addAttribute("schedules", insu.ListAllPolicySchedulesById(id));
		return "ViewScheduleByIds";
	}

}