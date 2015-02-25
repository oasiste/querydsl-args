package me.yanaga.querydsl.args.core;

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

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.expr.ComparableExpression;
import me.yanaga.querydsl.args.core.range.Range;

public interface RangeArgument<T extends ComparableExpression<V>, V extends Comparable<V>> extends Argument<T, Range<V>> {

	@SuppressWarnings("unchecked")
	public default void append(BooleanBuilder builder, T path, T... paths) {
		append(builder, (t, range) -> t.goe(range.getBegin()).and(t.loe(range.getEnd())), path, paths);
	}

}