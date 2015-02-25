package me.yanaga.querydsl.args.core.range;

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

import com.google.common.base.Strings;
import com.mysema.query.types.path.ComparablePath;
import me.yanaga.querydsl.args.core.RangeArgument;

public interface RangeLongArgument extends RangeArgument<ComparablePath<Long>, Long> {

	public static RangeLongArgument of(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			String digits = value.replaceAll("\\D", "");
			if (digits.matches("\\d+")) {
//				return new SingleLongArgument(Long.valueOf(digits));
			}
		}
		return new EmptyLongArgument();
	}

	public static RangeLongArgument of() {
		return new EmptyLongArgument();
	}

}