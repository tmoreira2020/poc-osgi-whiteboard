/**
 * Copyright © 2014 Thiago Moreira (tmoreira2020@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.thiagomoreira.bot.impl;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.thiagomoreira.bot.api.Bot;

@Component(service = Bot.class, factory = "bot.factory")
public class BotImpl implements Bot {

	protected Logger logger = LoggerFactory.getLogger(BotImpl.class);

	@Activate
	public void activate(BundleContext context) {
		logger.info("Activating " + getClass().getName());
	}

	@Deactivate
	public void close() {
		logger.info("Deactivating " + getClass().getName());
	}

	public void run() {
		logger.info("Running " + getClass().getName());
	}

}
