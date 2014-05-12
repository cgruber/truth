package org.truth0.subjects;

import org.truth0.FailureStrategy;

public abstract class AbstractNumericSubject<T extends Number> extends
        Subject<AbstractIntegralNumericSubject<T>, T> {

  public AbstractNumericSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  protected abstract char symbol();

  @Override
  protected String getDisplaySubject() {
    return (internalCustomLabel() == null)
            ? "<" + getSubject().toString() + symbol() + ">"
            : "\"" + this.internalCustomLabel() + "\"";
  }

}