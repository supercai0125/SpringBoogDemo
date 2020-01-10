package com.csq.dockercomposespringbootmysqlnginx.repository;

import com.csq.dockercomposespringbootmysqlnginx.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ercai
 * @date 2020/1/10 - 10:00
 */
public interface  VisitorRepository extends JpaRepository<Visitor, Long> {
    Visitor findByIp(String ip);
}
