/*
 * Copyright 2021 Vaibhav Nargwani
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
package net.vpg.bot.commands;

import net.vpg.bot.core.Bot;
import net.vpg.bot.event.CommandReceivedEvent;

public abstract class MusicCommand extends BotCommandImpl {
    public static boolean owner = false;

    public MusicCommand(Bot bot, String name, String description, String... aliases) {
        super(bot, name, description, aliases);
    }

    @Override
    public void run(CommandReceivedEvent e) {
        if (owner && e.getUser().getIdLong() != e.getBot().getOwnerId()) return;
        super.run(e);
    }
}
