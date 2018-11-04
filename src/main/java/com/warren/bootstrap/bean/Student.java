package com.warren.bootstrap.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/2 16:37
 */
@Data
@AllArgsConstructor
public class Student {
	private String name;
	private Date time;
	private String nationality;

}
