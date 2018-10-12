/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.swagger.converter.property;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SwaggerParamCollectionFormatTest {
  @Test
  public void splitParamNormal() {
    Assert.assertThat(SwaggerParamCollectionFormat.CSV.splitParam("a,b,c"),
        Matchers.arrayContaining("a", "b", "c"));
    Assert.assertThat(SwaggerParamCollectionFormat.SSV.splitParam("10 11 12"),
        Matchers.arrayContaining("10", "11", "12"));
    Assert.assertThat(SwaggerParamCollectionFormat.TSV.splitParam("a\tb\tc"),
        Matchers.arrayContaining("a", "b", "c"));
    Assert.assertThat(SwaggerParamCollectionFormat.PIPES.splitParam("a|b|c"),
        Matchers.arrayContaining("a", "b", "c"));
  }

  @Test
  public void splitParamMulti() {
    Assert.assertThat(SwaggerParamCollectionFormat.MULTI.splitParam("a,b,c"),
        Matchers.arrayContaining("a,b,c"));
  }

  @Test
  public void splitParam_SingleElement() {
    Assert.assertThat(SwaggerParamCollectionFormat.CSV.splitParam("a"),
        Matchers.arrayContaining("a"));
    Assert.assertThat(SwaggerParamCollectionFormat.SSV.splitParam("a"),
        Matchers.arrayContaining("a"));
    Assert.assertThat(SwaggerParamCollectionFormat.TSV.splitParam("a"),
        Matchers.arrayContaining("a"));
    Assert.assertThat(SwaggerParamCollectionFormat.PIPES.splitParam("a"),
        Matchers.arrayContaining("a"));
    Assert.assertThat(SwaggerParamCollectionFormat.MULTI.splitParam("a"),
        Matchers.arrayContaining("a"));
  }

  @Test
  public void splitParam_NullElement() {
    Assert.assertThat(SwaggerParamCollectionFormat.CSV.splitParam(null),
        Matchers.emptyArray());
    Assert.assertThat(SwaggerParamCollectionFormat.SSV.splitParam(null),
        Matchers.emptyArray());
    Assert.assertThat(SwaggerParamCollectionFormat.TSV.splitParam(null),
        Matchers.emptyArray());
    Assert.assertThat(SwaggerParamCollectionFormat.PIPES.splitParam(null),
        Matchers.emptyArray());
    Assert.assertThat(SwaggerParamCollectionFormat.MULTI.splitParam(null),
        Matchers.emptyArray());
  }

  @Test
  public void splitParam_BlankElement() {
    Assert.assertThat(SwaggerParamCollectionFormat.CSV.splitParam(""),
        Matchers.arrayContaining(""));
    Assert.assertThat(SwaggerParamCollectionFormat.SSV.splitParam(""),
        Matchers.arrayContaining(""));
    Assert.assertThat(SwaggerParamCollectionFormat.TSV.splitParam(""),
        Matchers.arrayContaining(""));
    Assert.assertThat(SwaggerParamCollectionFormat.PIPES.splitParam(""),
        Matchers.arrayContaining(""));
    Assert.assertThat(SwaggerParamCollectionFormat.MULTI.splitParam(""),
        Matchers.arrayContaining(""));
  }
}