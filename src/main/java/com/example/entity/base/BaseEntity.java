package com.example.entity.base;

import com.example.utils.DateUtil;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "deleteFlag")
    private Boolean deleteFlag;

    @PrePersist
    protected void prePersist(){
        Date now = DateUtil.now();

        if(createTime == null){
            createTime = now;
        }

        if(updateTime == null){
            updateTime = now;
        }

        if(deleteFlag == null){
            deleteFlag = false;
        }
    }
}
