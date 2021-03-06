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

public class SingleIntegerArgument extends SingleNumberArgument<Integer> {

	private static final long serialVersionUID = 1L;

	private SingleIntegerArgument(Integer value) {
		super(value);
	}

	public static SingleIntegerArgument of(Integer value) {
		return new SingleIntegerArgument(value);
	}

	public static SingleIntegerArgument of() {
		return of(null);
	}

}
