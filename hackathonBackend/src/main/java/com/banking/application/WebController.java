package com.banking.application;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.banking.application.database.User;
import java.util.*;

@RestController

public class WebController {

	private final JdbcTemplate jdbcTemplate;
	public User user;
	private Map<String, Object> userMap;

	WebController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/")
	public String workingCheck() {
		return "Application is running";
	}

	@PostMapping("/userLogin")
	public String loginUser(@RequestParam String number, @RequestParam String password) {
		if ((password).equals(
				jdbcTemplate.queryForObject("SELECT PASSWORD FROM USER_INFO WHERE PH_NO=" + number, String.class))) {
			userMap = jdbcTemplate.queryForMap("SELECT * FROM USER_INFO WHERE PH_NO=" + number);
			user = new User(userMap.get("NAME").toString(),
					userMap.get("PH_NO").toString(), userMap.get("USER_ID").toString());
			return user.getUserID();
		}
		return "Invalid login";
	}

	@RequestMapping(value = "/transactionHistory", method = RequestMethod.POST, params = {"startDate", "endDate"})
	public List<Map<String, Object>> transactions(@RequestParam String startDate,
			@RequestParam String endDate) {
		return jdbcTemplate.queryForList("SELECT * FROM USER_TRANSACTIONS WHERE USER_ID='" + user.getUserID() + "'"
				+ " AND TRANSACTION_DATE>='" + startDate + "'" + " AND TRANSACTION_DATE<='" + endDate + "'"
				+ " ORDER BY TRANSACTION_DATE DESC");
	}
	
	@RequestMapping(value = "/transactionHistory", method = RequestMethod.POST, params = {})
	public List<Map<String, Object>> transactions()
	{ 
		return jdbcTemplate.queryForList("SELECT * FROM USER_TRANSACTIONS WHERE USER_ID='" + user.getUserID() + "'"
				+ " ORDER BY TRANSACTION_DATE DESC LIMIT 10"); 
	}
	
}
