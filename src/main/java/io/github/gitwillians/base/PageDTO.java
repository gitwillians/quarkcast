package io.github.gitwillians.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageDTO {

	private int pageIndex; 
	private int pageSize; 
	private String sortBy; 
	private Boolean ascending;
}