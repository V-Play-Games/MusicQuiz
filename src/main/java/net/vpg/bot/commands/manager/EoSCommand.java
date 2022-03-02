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
package net.vpg.bot.commands.manager;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.vpg.bot.commands.BotCommandImpl;
import net.vpg.bot.commands.NoArgsCommand;
import net.vpg.bot.core.Bot;
import net.vpg.bot.event.CommandReceivedEvent;

public class EoSCommand extends BotCommandImpl implements ManagerCommand, NoArgsCommand {
    public EoSCommand(Bot bot) {
        super(bot, "eos", "eos");
    }

    @Override
    public void execute(CommandReceivedEvent e) throws Exception {
        bot.getShardManager()
            .getGuildCache()
            .forEach(guild -> guild.retrieveOwner()
                .map(Member::getUser)
                .flatMap(User::openPrivateChannel)
                .flatMap(channel -> channel.sendMessage(
                    "Dear " + channel.getUser().getName() + "," +
                    "\n    Greetings of the day! I, the bot, wants to bring to your kind attention," +
                    " on behalf of my developer, V Play Games, that, effective now, I will no longer be serving you any" +
                    " sort of service as my end of service has been declared because the developer's interest" +
                    " in the bot has lifted off." +
                    "\n    Thank You for adding me to your server." +
                    " You're now free to, and advised to, remove me from your server(s)." +
                    "\nThanking you," +
                    "\nYours faithfully," +
                    "\nV Play Music"))
                .queue()
            );
    }
}
