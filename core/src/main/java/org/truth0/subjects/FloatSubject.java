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

@GwtCompatible
public class FloatSubject extends Subject<FloatSubject, Float> {
  public FloatSubject(FailureStrategy failureStrategy, Float o) {
    super(failureStrategy, o);
  }

  @Override protected String getDisplaySubject() {
    return (internalCustomLabel() == null)
            ? "<" + getSubject().toString() + "F>"
            : "\"" + this.internalCustomLabel() + "\"";
  }

  /**
   * This form is unsafe for floating point types, and will throw an
   * {@link UnsupportedOperationException}.
   *
   * @deprecated use {@link #isEqualTo(Object, float)}
   */
  @Deprecated
  @Override public void isEqualTo(Object expected) {
    throw new UnsupportedOperationException("Comparing raw equality of floats is unsafe, "
        + "use isEqualTo(Object float, float tolerance) instead.");
  }

  /**
   * Fails if the provided {@code expectedFloat} is not a {@code float} (or {@link Float}),
   * or is not numerically equivalent to the subject to within the provided {@code tolerance}.
   */
  public void isEqualTo(Object expectedFloat, double tolerance) {
    try {
      Float expected = (Float) expectedFloat;
      if (Float.compare(getSubject(), expected) != 0) {
        failWithRawMessage("%s does not equal expected %s to within %s tolerance.",
            getDisplaySubject(), expected, tolerance);
      }
    } catch (ClassCastException e) {
      String expectedType = (expectedFloat.getClass().isArray())
          ? expectedFloat.getClass().getComponentType().getName() + "[]"
          : expectedFloat.getClass().getName();
      failWithRawMessage(
          "Incompatible types compared. expected: %s, actual: %s", expectedType, "float[]");
    }
  }

  /**
   * This form is unsafe for floating point types, and will throw an
   * {@link UnsupportedOperationException}.
   *
   * @deprecated use {@link #isNotEqualTo(Object, float)}
   */
  @Deprecated
  @Override public void isNotEqualTo(Object expected) {
    throw new UnsupportedOperationException("Comparing raw equality of floats is unsafe, "
        + "use isNotEqualTo(Object array, float tolerance) instead.");
  }

  /**
   * Fails if the provided {@code expectedFloat} is actually a {@code float} (or {@link Float}),
   * and is numerically equivalent to the subject to within the provided {@code tolerance}.
   */
  public void isNotEqualTo(Object expectedFloat, float tolerance) {
    try {
      Float expected = (Float) expectedFloat;
      if (Float.compare(getSubject(), expected) == 0) {
        failWithRawMessage("%s is unexpectedly equal to %s to within %s tolerance.",
            getDisplaySubject(), expected, tolerance);
      }
    } catch (ClassCastException ignored) {} // Unequal types are unequal values.
  }
}
