package com.ssafy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BoardParameterDto {

	private int pg;
	private int spp;
	private int start;
	private String key;
	private String word;
	
	public BoardParameterDto() {
		pg = 1;
		spp = 20;
	}

	public void setPg(int pg) {
		pg = pg == 0 ? 1 : pg;
		this.pg = pg;
	}
}

