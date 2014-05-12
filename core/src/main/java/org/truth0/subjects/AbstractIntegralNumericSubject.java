/*
 * Copyright (c) 2014 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.truth0.subjects;


import com.google.common.annotations.GwtCompatible;

import org.truth0.FailureStrategy;

/**
 * A supertype for Integral numeric subjects.
 */
@GwtCompatible
public abstract class AbstractIntegralNumericSubject<T extends Number>
    extends AbstractNumericSubject<T> {
  public AbstractIntegralNumericSubject(FailureStrategy failureStrategy, T o) {
    super(failureStrategy, o);
  }

  // Require explicit override for the type.
  @Override public void isEqualTo(Object expected) {
    throw new UnsupportedOperationException();
  }

  // Require explicit override for the type.
  @Override public abstract void isNotEqualTo(Object expected);


  public void isGreaterThan(Number expected) {
    throw new UnsupportedOperationException();
  }

  public void isGreaterThanOrEqualTo(Number expected) {
    throw new UnsupportedOperationException();
  }

  public void isLessThan(Number expected) {
    throw new UnsupportedOperationException();
  }

  public void isLessThanOrEqualTo(Number expected) {
    throw new UnsupportedOperationException();
  }

}
