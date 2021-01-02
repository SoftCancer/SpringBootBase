package com.ygx.bootbase.common.result;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageView implements Serializable {

    private static final long serialVersionUID = 7237733789548073354L;

    // 总记录数
    private String total;
    // 分页数据
    private List<?> rows;
}
