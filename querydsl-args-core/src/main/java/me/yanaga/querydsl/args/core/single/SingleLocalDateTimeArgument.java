package me.yanaga.querydsl.args.core.single;

/*
 * #%L
 * queydsl-args
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


import com.querydsl.core.types.dsl.DateTimeExpression;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.google.common.base.Preconditions.checkNotNull;

public class SingleLocalDateTimeArgument extends AbstractTemporalArgument<DateTimeExpression<LocalDateTime>, LocalDateTime> {

	private static final long serialVersionUID = 1L;

	private SingleLocalDateTimeArgument(LocalDateTime value) {
		super(value);
	}

	public static SingleLocalDateTimeArgument of(LocalDateTime value) {
		return new SingleLocalDateTimeArgument(value);
	}

	public static SingleLocalDateTimeArgument of() {
		return of(null);
	}

	@Override
	public String format(DateTimeFormatter formatter) {
		checkNotNull(formatter);
		return value.format(formatter);
	}

}
