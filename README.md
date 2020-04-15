# JDACommons
This is a utils repository for JDA:4.1.1_127

## Using Commandsystem
This repository has got an own command system. To use it, you have to create a new System.
```java
jda = new JDABuilder(AccountType.BOT)
  ...
  .addEventListener(new CommandHandlerBuilder("YOUR COMMAND PREFIX", BOTS_CAN_USE_COMMANDS (optional, boolean), WEBHOOKS_CAN_USE_COMMANDS (optional, boolean))
  .addCommand(COMMAND)
  .addCommand(COMMAND2).build())
  ...
```
To create a new command, you have got two different options: private commands and guild commands

**Guild Commands**
```java
public class MyGuildCommand implements Command {
  public void getInvoke() {
    return "foo";
  }
  public void getHelp() {
    return "Your help (to get the Command Prefix use `getPrefix()`";
  }
  public void execute(GuildMessageRecievedEvent event, String[] args) {
    // Todo: Do sth
  }
}
```
**Private Commands**
```java
public class MyGuildCommand implements PrivateCommand {
  public void getInvoke() {
    return "foo";
  }
  public void getHelp() {
    return "Your help (to get the Command Prefix use `getPrefix()`";
  }
  public void execute(MessageRecievedEvent event, String[] args) {
    // Todo: Do sth
  }
}
```

## Implementation
### Maven
You have to implement the JDA from net.dv8tion, otherwise this repository won't work and you cannot make your Bot with this repository
```xml
<dependency>
  <groupId>net.dv8tion</groupId>
  <artifactId>JDA</artifactId>
  <version>JDA-VERSION</version>
</dependency>
```

## Contributors
[ce_phox](https://github.com/cephox)
