/**
 * Copyright 2013-2014 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.rasc.edsutil.optimizer.config;

public class WebResourceConfig {

	enum WebResourceType {
		ignore, script, link, concat_minify
	}

	public String path;
	public WebResourceType dev;
	public WebResourceType prod;
	public String classpath;

	public boolean isDevScriptOrLink() {
		return dev != null
				&& (dev == WebResourceType.link || dev == WebResourceType.script);
	}

	public boolean isProd() {
		return prod != null && prod != WebResourceType.ignore;
	}

	public boolean isProdScriptOrLink() {
		return prod != null
				&& (prod == WebResourceType.script || prod == WebResourceType.link);
	}
}