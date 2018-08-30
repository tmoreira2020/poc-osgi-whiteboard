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
package br.com.thiagomoreira.application;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentFactory;
import org.osgi.service.component.ComponentInstance;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.thiagomoreira.bot.api.Bot;

@Component(immediate = true, service = Object.class)
public class BotApplication {

	protected Logger logger = LoggerFactory.getLogger(BotApplication.class);
	protected BundleContext context;
	protected ServiceRegistration<Bot> serviceRegistration;
	@Reference(target = "(component.factory=bot.factory)")
	protected ComponentFactory factory;

	@Activate
	public void activate(BundleContext context) {
		logger.info("********************** Initialization **********************");

		Dictionary<String, Object> properties = new Hashtable<>();

		ComponentInstance componentInstance = factory.newInstance(properties);

		Bot bot = (Bot) componentInstance.getInstance();

		bot.run();

		logger.info("************************************************************");
	}
}
