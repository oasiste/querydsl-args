package me.yanaga.querydsl.args.core.single;

/*
 * #%L
 * querydsl-args-core
 * %%
 * Copyright (C) 2014 - 2015 Edson Yanaga
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.querydsl.args.core.TestConfig;
import me.yanaga.querydsl.args.core.model.Person;
import me.yanaga.querydsl.args.core.model.QPerson;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TestConfig.class)
public class SingleLocalDateArgumentTest extends AbstractTransactionalTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager entityManager;

	@BeforeMethod
	public void setUp() {
		Person person = new Person();
		person.setOneLocalDate(LocalDate.of(2015, 2, 25));
		person.setAnotherLocalDate(LocalDate.of(2015, 2, 27));
		entityManager.persist(person);
	}

	@Test
	public void testAppendDefaultOneArgument() {
		SingleLocalDateArgument argument = SingleLocalDateArgument.of(LocalDate.of(2015, 2, 25));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.oneLocalDate);
		Person result = new JPAQuery<Person>(entityManager).from(QPerson.person).where(builder).fetchOne();
		assertThat(result).isNotNull();
		assertThat(result.getOneLocalDate()).isEqualTo(LocalDate.of(2015, 2, 25));
	}

}
