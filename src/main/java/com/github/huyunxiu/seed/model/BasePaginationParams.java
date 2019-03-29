package com.github.huyunxiu.seed.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;

/**
 * 基础分页参数
 *
 * @author huyunxiu01@gmail.com
 * @since 2019-03-29
 */
@Data
@ApiModel(value = "基础分页参数")
public class BasePaginationParams {

	@ApiModelProperty(value = "页码", example = "1")
	private Integer pageNumber = 1;

	@ApiModelProperty(value = "页码", example = "10")
	@Max(value = 100, message = "单页最多显示100条数据")
	private Integer pageSize = 10;
}
