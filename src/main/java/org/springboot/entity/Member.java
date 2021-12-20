package org.springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// 롬복
@Entity					// 이것을 통해 
@Builder				// 객체 자동 생성해주는 것.
@AllArgsConstructor		// 생성자를 만들어 준다.
@NoArgsConstructor		// 기본 생성자도 만들어 줘.
@Table(name = "member")	// 메모테이블이 있다면 쓰고, 없으면 만들어준다.
public class Member {	// jpa에서 기본 쓰는 문법이 있다. 만약 create table memo (m_no int primary key ) 이런식으로 한다면
	 					// jpa에서는 ID가 pk값으로 잡힌다.
	@Id					// pk라고 알려준다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 어떤 식으로 들어올껀데 밑에께 오토 인크리먼트. pk면서 autoincrement가 잡혀있다는 뜻
	private Long mNo;

	@Column(length = 10, nullable = false, unique = true)	// 글자수 제한10자 // 널일수 있니? 아니요. == not null이다.       
	private String mId;
	
	@Column(length = 20, nullable = false)  
	private String mPassword;
	
	@Column(length = 20, nullable = false)  
	private String mName;
}
