# JDACommons
This is a utils repository for JDA:4.1.1_127

## Using Commandsystem
This repository has got an own command system. To use it, you have to create a new System.
```java
jda = new JDABuilder(AccountType.BOT)
  ...
  .addEventListener(new CommandHandlerBuilder("YOUR COMMAND PREFIX", BOTS_CAN_USE_COMMANDS (optional, boolean), WEBHOOKS_CAN_USE_COMMANDS (optional, boolean))
  .addCommand()
  ...)
  ...
```

## Implementation
**Implementing JDA**

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
