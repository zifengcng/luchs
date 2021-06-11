package com.luchs.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author cheng
 * @Date 2021/5/7
 */
@Data
public class BillVipPointsLimitFindReq {

    //    @ApiModelProperty(value = "门店编码")
    private String store_code;

    //    @ApiModelProperty(value = "店铺编码")
    private String shop_code;

    //    @ApiModelProperty(value = "单据编号")
    private String billno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @ApiModelProperty(value = "审核时间-开始(yyyy-MM-dd)")
    private Date gmt_audit_start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @ApiModelProperty(value = "审核时间-结束(yyyy-MM-dd)")
    private Date gmt_audit_end;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd 00:00:00", timezone = "GMT+8")
//    @ApiModelProperty(value = "创建时间-开始(yyyy-MM-dd)")
    private Date gmt_create_start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd 23:59:59", timezone = "GMT+8")
//    @ApiModelProperty(value = "创建时间-结束(yyyy-MM-dd)")
    private Date gmt_create_end;

    //    @ApiModelProperty(value = "单据状态 1 待审核 / 2 已审核 / 3 停用")
    private Byte bill_status;

    //    @ApiModelProperty(value = "审核人")
    private Integer audit_user;

    //    @ApiModelProperty(value = "创建人")
    private Integer create_user;

}
