/*
 * =============================================================================
 *
 *   Copyright (c) 2013, Connect Group (http://www.connect-group.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.connect_group.thymesheet.sample.beans;

public class LinkBean {
	private String href;
	private String text;
	
	public LinkBean(String url, String text) {
		this.setHref(url);
		this.setUtext(text);
	}

	public String getHref() {
		return href;
	}

	public void setHref(String url) {
		this.href = url;
	}

	public String getUtext() {
		return text;
	}

	public void setUtext(String text) {
		this.text = text;
	}
}
