package com.rbanos.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rbanos.user.VO.Department;
import com.rbanos.user.VO.ResponseTemplateVO;
import com.rbanos.user.entity.User;
import com.rbanos.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  public User saveUser(User user) {
    log.info("Inside UserService.saveUser method");
    return userRepository.save(user);
  }

  public ResponseTemplateVO getUserWithDepartment(Long userId) {
    log.info("Inside UserService.getUserWithDepartment method");
    ResponseTemplateVO vo = new ResponseTemplateVO();
    User user = userRepository.findByUserId(userId);
    Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
        Department.class);
    vo.setUser(user);
    vo.setDepartment(department);

    return vo;
  }
}
