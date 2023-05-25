package com.ssafy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private int board_id;
	private String user_id;
	private String title;
	private String content;
	private int hit;
	private String created_date;
	private String modified_date;
}