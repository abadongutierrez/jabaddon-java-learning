package com.jabaddon.learning.spring.springscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope(value = "prototype")
public class MyPrototypeComponent {
}
