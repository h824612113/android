/*
 * Copyright (C) 2016 The Android Open Source Project
 *
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
 */
package com.android.tools.idea.gradle.structure.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class PsdModel {
  @Nullable private final PsdModel myParent;

  private boolean myModified;

  protected PsdModel(@Nullable PsdModel parent) {
    myParent = parent;
  }

  @NotNull
  public abstract String getName();

  public abstract boolean isEditable();

  @Nullable
  public PsdModel getParent() {
    return myParent;
  }

  public boolean isModified() {
    return myModified;
  }

  public void setModified(boolean value) {
    myModified = value;
    if (myModified && myParent != null) {
      myParent.setModified(true);
    }
  }

  @Nullable
  public Icon getIcon() {
    return null;
  }

  @Nullable
  public PsdProblem getProblem() {
    return null;
  }

  @Override
  public String toString() {
    return getName();
  }
}