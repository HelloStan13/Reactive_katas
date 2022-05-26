package io.pivotal.literx;
import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

	// TODO Capitalize the user username, firstname and lastname
	Mono<User> capitalizeOne(Mono<User> mono) {
		 return mono.map(users -> new User(users.getUsername().toUpperCase(),
										 users.getFirstname().toUpperCase(),
										 users.getLastname().toUpperCase()));
	}



//========================================================================================

	// TODO Capitalize the users username, firstName and lastName
	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(users -> new User(
				users.getUsername().toUpperCase(),
				users.getFirstname().toUpperCase(),
				users.getLastname().toUpperCase()));
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
