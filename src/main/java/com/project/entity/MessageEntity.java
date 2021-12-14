package com.project.entity;

import org.hibernate.annotations.Table;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Entity
@Table(name = "message")
@Where(clause = "is_deleted=false")
public class MessageEntity {

}
