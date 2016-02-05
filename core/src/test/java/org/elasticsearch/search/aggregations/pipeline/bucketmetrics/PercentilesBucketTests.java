/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.aggregations.pipeline.bucketmetrics;

import org.elasticsearch.search.aggregations.pipeline.bucketmetrics.percentile.PercentilesBucketPipelineAggregator;
import org.elasticsearch.search.aggregations.pipeline.bucketmetrics.percentile.PercentilesBucketPipelineAggregator.Factory;

public class PercentilesBucketTests extends AbstractBucketMetricsTestCase<PercentilesBucketPipelineAggregator.Factory> {

    @Override
    protected Factory doCreateTestAggregatorFactory(String name, String bucketsPath) {
        Factory factory = new Factory(name, bucketsPath);
        if (randomBoolean()) {
            int numPercents = randomIntBetween(1, 20);
            double[] percents = new double[numPercents];
            for (int i = 0; i < numPercents; i++) {
                percents[i] = randomDoubleBetween(0.0, 100.0, false);
            }
            factory.percents(percents);
        }
        return factory;
    }


}