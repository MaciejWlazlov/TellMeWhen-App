package com.portfolio.tellmewhenapp.service;

import com.portfolio.tellmewhenapp.user.dto.UserDto;
import com.portfolio.tellmewhenapp.user.entity.User;

public interface IUserService {

   User registerNewUserAccount(UserDto userDto);
}
