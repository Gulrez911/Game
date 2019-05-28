package com.kgate.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kgate.entity.Question;
import com.kgate.entity.User;
import com.kgate.entity.UserInfo;
import com.kgate.exception.ResourceNotFoundExceptionTest;
import com.kgate.repository.UserRepository;
import com.kgate.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository repo;

	public UserController() {
	}

	@PostMapping({ "/saveUser" })
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		System.out.println("save called");
		User usr = userService.saveUser(user);

		return ResponseEntity.ok().body("user saved...  " + usr);
	}

//	@PostMapping({ "/saveUserGame" })
//	public ResponseEntity<?> saveUserGame(@RequestBody UserGame userGame) {
//		System.out.println("save called");
//		UserGame user = null;
//		try {
//			user = userService.addUserGame(userGame);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (user == null) {
//			return ResponseEntity.ok().body("Mobile No. Doesn't Exist");
//		}
//
//		return ResponseEntity.ok().body("user saved...  ");
//	}

//	@PostMapping({ "/saveUserGame" })
//	public ResponseEntity<?> saveUserGame(@RequestBody String json) {
//		System.out.println("save called");
//		JSONObject jsonObject = new JSONObject(json);
////		String userinfo = jsonObject.getString("UserInfo");
//
//		String m = jsonObject.get("phoneNumber").toString();
//		String t = jsonObject.get("feedback").toString();
//		String n1 = jsonObject.get("duration").toString();
//		String n2 = jsonObject.get("dateTime").toString();
//		String n3 = jsonObject.get("percentage").toString();
//		System.out.println(m + " " + t + " " + n1 + " " + n2 + " " + n3);
//		UserInfo userInfo = new UserInfo();
//		userInfo.setPhoneNumber(Long.parseLong(m));
//		userInfo.setFeedback(t);
//		userInfo.setDuration(n1);
//		userInfo.setDateTime(n2);
//		userInfo.setPercentage(n3);
//		UserInfo user = null;
//		List<Question> listq = new ArrayList<>();
//		Question e = new Question();
//		e.setMobile(Long.parseLong("23425"));
//		e.setObjective("objective");
//		e.setOptions("true");
//		e.setqNo("121");
//		e.setQuestion("QuestionText");
//		e.setResult("pass");
//		e.setType("complex");
//		listq.add(e);
//		userInfo.setQuestions(listq);
//
//		try {
//			user = userService.saveUserInfo(userInfo);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		if (user == null) {
//			return ResponseEntity.ok().body("Mobile No. Doesn't Exist");
//		}
//
//		return ResponseEntity.ok().body("user saved...  ");
//	}

	@PostMapping({ "/saveUserGame" })
	public ResponseEntity<?> saveUserGame(@RequestBody String json) throws Exception {
		System.out.println("save called");
 
		JSONObject jsonObject = new JSONObject(json);
		JSONObject getObject = jsonObject.getJSONObject("UserInfo");
		JSONArray getArray = jsonObject.getJSONArray("Question");

//			

		String phone = (String) getObject.get("phoneNumber");
		String feedback = (String) getObject.get("feedback");
		String duration = (String) getObject.get("duration");
		String dateTime = (String) getObject.get("dateTime");
		String percentage = (String) getObject.get("percentage");
		System.out.println("done: " + phone + " " + feedback + " " + duration + " " + dateTime + " "
				+ percentage);
//		increment for attempt
//		UserInfo info = null;
//		try {
//			info = userService.getUserInfoDetails(Long.parseLong(phone));
//		} catch (NumberFormatException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ResourceNotFoundExceptionTest e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		if (info != null) {
//			info.setNoOfAttempts(info.getNoOfAttempts() + 1);
//			// userRepository.save(user);
//		} else {
//			throw new Exception(" user not found");
//		}

//		
		List<Question> listquestion = new ArrayList<Question>();
		for (int i = 0; i < getArray.length(); i++) {
			JSONObject objects = getArray.getJSONObject(i);

 
			Question q2 = new Question();
			String objective = (String) objects.get("objective");
			String qNo = (String) objects.get("qNo");
			String question = (String) objects.get("question");
			String option = (String) objects.get("option");
			String result = (String) objects.get("result");
			String type = (String) objects.get("type");
			System.out.println("question: " + objective + " " + qNo + " " + question + " " + option
					+ " " + result + " " + type);
			q2.setObjective(objective);
			q2.setqNo(qNo);
			q2.setOptions(option);
			q2.setQuestion(question);
			q2.setResult(result);
			q2.setType(type);
			q2.setMobile((long) 3242342);
			listquestion.add(q2);

//			}

		}
//		String m = jsonObject.get("phoneNumber").toString();
//		String m = "123123";
//		String t = jsonObject.get("feedback").toString();
//		String n1 = jsonObject.get("duration").toString();
//		String n2 = jsonObject.get("dateTime").toString();
//		String n3 = jsonObject.get("percentage").toString();
//		System.out.println(m + " " + t + " " + n1 + " " + n2 + " " + n3);
		UserInfo userInfo = new UserInfo();
//		userInfo.setPhoneNumber(Long.parseLong(m));
//		userInfo.setFeedback(t);
//		userInfo.setDuration(n1);
//		userInfo.setDateTime(n2);
//		userInfo.setPercentage(n3);
		userInfo.setPhoneNumber(Long.parseLong(phone));
		userInfo.setFeedback(feedback);
		userInfo.setDuration(duration);
		userInfo.setDateTime(dateTime);
		userInfo.setPercentage(percentage);
		UserInfo user = null;
//		List<Question> listq = new ArrayList<>();
//		Question e = new Question();
//		e.setMobile(Long.parseLong("23425"));
//		e.setObjective("objective");
//		e.setOptions("true");
//		e.setqNo("121");
//		e.setQuestion("QuestionText");
//		e.setResult("pass");
//		e.setType("complex");
//		listq.add(e);
		userInfo.setQuestions(listquestion);

		try {
			user = userService.saveUserInfo(userInfo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (user == null) {
			return ResponseEntity.ok().body("Mobile No. Doesn't Exist");
		}

		return ResponseEntity.ok().body("user saved...  ");
	}

	@org.springframework.web.bind.annotation.GetMapping({ "/getUserDetails/{mobile}" })
	public ResponseEntity<?> getUserDetails(
			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile) {
		System.out.println("method called");

		UserInfo user2 = null;
		try {
			user2 = userService.getUserInfoDetails(mobile);
		} catch (ResourceNotFoundExceptionTest e) {
			e.printStackTrace();
		}

		if (user2 == null) {
			return ResponseEntity.ok().body("No_User_Exists");
		}

//		user2.setUserGame(null);
		System.out.println("repo:  " + user2);
		return ResponseEntity.ok().body(user2);
	}

//	@org.springframework.web.bind.annotation.GetMapping({ "/getUserDetails/{mobile}" })
//	public ResponseEntity<?> getUserDetails(
//			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile) {
//		System.out.println("method called");
//
//		User user2 = null;
//		try {
//			user2 = userService.getUserDetails(mobile);
//		} catch (ResourceNotFoundExceptionTest e) {
//			e.printStackTrace();
//		}
//
//		if (user2 == null) {
//			return ResponseEntity.ok().body("No_User_Exists");
//		}
//
//		user2.setUserGame(null);
//		System.out.println("repo:  " + user2);
//		return ResponseEntity.ok().body(user2);
//	}
}