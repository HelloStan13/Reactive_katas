package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

	// TODO Capitalize the user username, firstname and lastname
	Mono<User> capitalizeOne(Mono<User> mono) {
		 return mono.map(user -> new User(user.getUsername().toUpperCase(),
									 user.getFirstname().toUpperCase(),
									 user.getLastname().toUpperCase()));
	}


//========================================================================================

	// TODO Capitalize the users username, firstName and lastName
	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(u -> new User(
				u.getUsername().toUpperCase(),
				u.getFirstname().toUpperCase(),
				u.getLastname().toUpperCase()));
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
	Flux<User> asyncCapitalizeMany(Flux<User> flux) {
		return flux.flatMap(users -> asyncCapitalizeUser(users));
	}

	Mono<User> asyncCapitalizeUser(User users) {
		return Mono.just(new User(users.getUsername().toUpperCase(),
				users.getFirstname().toUpperCase(),
				users.getLastname().toUpperCase()));
	}

}
