package com.example.sprningboote.controllers;

import com.example.sprningboote.itcomp.Employee;
import com.example.sprningboote.itcomp.EmployeeService;
import com.example.sprningboote.transport.Rota;
import com.example.sprningboote.transport.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("example")
public class RestController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TransportService transportService;

	@RequestMapping(value = "employee-records", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getRecords(@RequestParam(name = "id") @Validated Long employeeId) {
		return employeeService.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("No employee Found"));
	}

	@PostMapping(value = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PostMapping(value = "transport", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Rota rota(@RequestBody Rota rota) {
		return transportService.addRota(rota);
	}


	@RequestMapping(value = "rota", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Rota getRotaRecords(@RequestParam(name = "id") @Validated Long rotaId) {
		return transportService.findRota(rotaId)
				.orElseThrow(() -> new IllegalArgumentException("No Rota Found"));
	}


}
