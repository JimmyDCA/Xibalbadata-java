package com.iitca.tecnodesarrollo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMsg {

	private int errorCode;
	private String messageCode;
}