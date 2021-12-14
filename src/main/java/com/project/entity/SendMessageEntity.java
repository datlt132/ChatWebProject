package com.project.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "send_message")
public class SendMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    private Long send_uid;

    private Long recv_uid;

    private Long mid;

    private Timestamp created_time;

    private Timestamp updated_time;

    private Timestamp send_at;

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public Timestamp getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Timestamp updated_time) {
        this.updated_time = updated_time;
    }

    public Timestamp getSend_at() {
        return send_at;
    }

    public void setSend_at(Timestamp send_at) {
        this.send_at = send_at;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getSend_uid() {
        return send_uid;
    }

    public void setSend_uid(Long send_uid) {
        this.send_uid = send_uid;
    }

    public Long getRecv_uid() {
        return recv_uid;
    }

    public void setRecv_uid(Long recv_uid) {
        this.recv_uid = recv_uid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public SendMessageEntity(Long send_uid, Long recv_uid, Long mid) {
        this.send_uid = send_uid;
        this.recv_uid = recv_uid;
        this.mid = mid;
    }
}
