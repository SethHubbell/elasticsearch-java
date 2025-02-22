/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.cluster;

import co.elastic.clients.elasticsearch._types.ClusterInfoTarget;
import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: cluster.info.Request

/**
 * Returns different information about the cluster.
 * 
 * @see <a href="../doc-files/api-spec.html#cluster.info.Request">API
 *      specification</a>
 */

public class ClusterInfoRequest extends RequestBase {
	private final List<ClusterInfoTarget> target;

	// ---------------------------------------------------------------------------------------------

	private ClusterInfoRequest(Builder builder) {

		this.target = ApiTypeHelper.unmodifiableRequired(builder.target, this, "target");

	}

	public static ClusterInfoRequest of(Function<Builder, ObjectBuilder<ClusterInfoRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Limits the information returned to the specific target. Supports a
	 * comma-separated list, such as http,ingest.
	 * <p>
	 * API name: {@code target}
	 */
	public final List<ClusterInfoTarget> target() {
		return this.target;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterInfoRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<ClusterInfoRequest> {
		private List<ClusterInfoTarget> target;

		/**
		 * Required - Limits the information returned to the specific target. Supports a
		 * comma-separated list, such as http,ingest.
		 * <p>
		 * API name: {@code target}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>target</code>.
		 */
		public final Builder target(List<ClusterInfoTarget> list) {
			this.target = _listAddAll(this.target, list);
			return this;
		}

		/**
		 * Required - Limits the information returned to the specific target. Supports a
		 * comma-separated list, such as http,ingest.
		 * <p>
		 * API name: {@code target}
		 * <p>
		 * Adds one or more values to <code>target</code>.
		 */
		public final Builder target(ClusterInfoTarget value, ClusterInfoTarget... values) {
			this.target = _listAdd(this.target, value, values);
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ClusterInfoRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterInfoRequest build() {
			_checkSingleUse();

			return new ClusterInfoRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cluster.info}".
	 */
	public static final Endpoint<ClusterInfoRequest, ClusterInfoResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/cluster.info",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _target = 1 << 0;

				int propsSet = 0;

				propsSet |= _target;

				if (propsSet == (_target)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_info");
					buf.append("/");
					SimpleEndpoint.pathEncode(
							request.target.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, ClusterInfoResponse._DESERIALIZER);
}
