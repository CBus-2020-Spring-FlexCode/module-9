package org.wcci.reviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Category movies = new Category("Movies");
		movies = categoryRepo.save(movies);
		Category comics = new Category("Comics");
		comics = categoryRepo.save(comics);
		Category music = new Category("Music");
		music = categoryRepo.save(music);
		
		Review maus = new Review("Maus", "/images/maus.jpeg", 
				"Maus, a two-part graphic novel written and drawn by Art Spiegelman, depicts his father's tale as a Jewish man during the holocaust. The graphic novel " +
				"depitcs the horrifying historical event with cats and mice. Yes, the Jewish people are depicted as mice and the nazis as cats. As interesting as the " +
				"holocaust is, the story is just as much about that as it is the realationship with Art and his father, Vladek. It reads as a memoir of Art's interviews" +
				"with his father twoards the end of his life.", comics);
			maus = reviewRepo.save(maus);
			Review eternalSunshine = new Review("Eternal Sunshine of the Spotless Mind", "/images/eternal-sunshine.jpeg", 
				"Eternal sunshine of the spottless mind is one of my favortie movies. It takes the classic American Romance movies and turns it on its head by " +
				"showing the fragility of memory and love. After Joel Barrish (Jim Carrey) and Clementine Kruczynski (Kate Winslet) find each other on a trip " +
				"skipping work, a relationship starts to bud after a few nights spent together. Soon we discover this is not a new relationship, and the two had " +
				"broken up recently and Clementine had her memory erased, eager to move on with her life. Upon discovering this, Joel decides to have his memory erased " +
				"as well. But as the procedure is being performed, the memories of fondness and tender love give him second thoughts and begins to fight the operation." +
				"We then follow Joel in his desperate quest to prevent the procedure.", movies);
			eternalSunshine = reviewRepo.save(eternalSunshine);
			Review remoDrive = new Review("Greatest Hits by Remo Drive", "/images/remo-drive.jpg",
				"Even though they were initially lumped in with the 2010s \"emo revival,\" Minnesota's Remo Drive take it a step beyond that designation on their first major-label " + 
				"full-length, Greatest Hits. Merging a distinct emo yearning with a D.I.Y. punk spirit and unpolished garage rock rawness, they deliver a solid debut fit for fans of Moose " + 
				"Blood, Tiny Moving Parts, and PUP, reaching as far back as Minor Threat and Weezer. Frontman Erik Paulson's vocals are imperfect but impassioned, while Sam Mathys pounds life " + 
				"into his drums and Stephen Paulson provides the occasional bounce on bass. Partially indebted to the sounds of the '90s -- check Nirvana and early Weezer -- Greatest Hits presents " + 
				"grunge crunch on the bitter, defeatist \"Hunting for Sport\" while dipping into rhythmic groove on \"Strawberita,\" likely the result of their love of the Police and Vampire Weekend. " + 
				"Additional highlights include the energetic \"Trying 2 Fool U\" -- which kicks off mean and harsh before elevating itself with a surprise Arcade Fire joy-explosion toward the end -- " + 
				"and the endearing \"Eat Shit,\" which turns skateboard fails into contemplations of existential woe. Moments like these set Greatest Hits apart from the pack with hints of depth and " + 
				"possibilities of more to come on future releases. Big single \"Yer Killin' Me\" is a standout, wonderfully defiant with lines like \"You make me want to start smoking cigarettes so I die " + 
				"slowly/Anything that's bad for me/yer killin' me.\" Yet it's also refreshingly unexpected, ending with a thoughtful and patient outro to calm the nerves. Packed with attitude and a healthy " + 
				"amount of riffs, Greatest Hits is music to blast with other outcast pals with chips on their shoulders, wiling the night away in the suburban wasteland.", music);
			remoDrive = reviewRepo.save(remoDrive);
			Review scottPilgrim = new Review("Scott Pilgrim vs. The World", "/images/scott-pilgrim.jpg", 
				"There are some movies about youth that just make you feel old, even if you aren’t. “Scott Pilgrim vs. the World,” based on a series of sprightly graphic novels " +
				"by Bryan Lee O’Malley, has the opposite effect. Its speedy, funny, happy-sad spirit is so infectious that the movie makes you feel at home in its world even if the landscape is, at first glance, unfamiliar. " + 
				"I don’t mean the streets of Toronto, where the movie is set, and which we have all seen on-screen before, usually pretending to be the streets of other cities." +
				"(“Wait, they make movies in Toronto?” says Scott Pilgrim, deadpanning one of a million quick little jokes threaded through the action.) The drab, mumbly realism with" +
				"which the director Edgar Wright depicts that city is offset — subverted, enlivened, thrown into crazy do-it-yourself pop-art relief — by images and situations drawn from arcade video games. " + 
				"These are part of Scott’s life in the usual way. He is a 22-year-old bass guitarist who plays the game Dance Dance Revolution on a date with one girlfriend and tries to impress both her and " +
				"another would-be girlfriend with arcane lore about the origins of Pac-Man. But Scott, played by Michael Cera with even less macho swagger than he showed in “Juno” and “Superbad” " +
				"(he has the voice of Gumby and the muscle tone to match), is also a video game character. His post-adolescent life — rehearsing with his band, mooning over some girls and avoiding others, " +
				"hanging out with his roommate, moping and napping and avoiding work — is periodically disrupted by spectacular battles with mighty foes. Their powers and his are tallied up on-screen, and " + 
				"he must negotiate a complex system of points, levels and lives of a kind easily recognizable to any joystick jockey. " + 
				"To say that “Scott Pilgrim vs. the World” is the best video game movie ever may sound like absurdly faint praise, though I have high hopes for “Tron: Legacy.” Most films that try to exploit " + 
				"the popularity of gaming mimic the look and mood of state-of-the-art first-person games, rather than the cruder, more cartoony ones evoked here. But Mr. Wright’s deeper ingenuity (and Mr. O’Malley’s) " + 
				"is to collapse the distance between gamer and avatar not by throwing the player into the world of the game, but rather by bringing it to him. (If you want to reverse this process there is now a Scott " + 
				"Pilgrim video game.) As a result, the line between fantasy and reality is not so much blurred as erased, because the filmmakers create an entirely coherent, perpetually surprising universe that builds on " + 
				"Mr. O’Malley’s bold and unpretentious graphic style without slavishly duplicating it. " + 
				"But back to Scott, who lives in a basement room with Wallace (Kieran Culkin), a gay best friend who happily embodies the stereotype even as he smashes it to pieces. " + 
				"Wallace is one of several characters who observe and comment on Scott’s life while conducting their own dramas in the margins of his mock-epic struggle. Another is Scott’s sister, " + 
				"Stacey (Anna Kendrick), who offers him not-so-patient advice on his girl troubles, which seem to be legion. When the story begins, Scott is still bruised after being dumped, a year earlier, " + 
				"by Envy (Brie Larson), who has gone on to become a rock star, with a recording contract and posters of her looking fierce all over town.\n" + 
				"In her absence, Scott pursues a chaste romance with a high-school student named Knives Chau (Ellen Wong), who thinks that he and his band, Sex Bob-omb, are the coolest things ever. " + 
				"In the case of the band, that’s almost true, since their frontman in a tormentedly unshaven Mark Webber, their drummer is an adorably scowly Alison Pill, and their caterwauling power-pop " + 
				"numbers were composed by Beck Hansen. So Scott may succeed in being cool by association, and he is happy enough to bask in Knives’s adoration until he meets Ramona Flowers (Mary Elizabeth Winstead), " + 
				"who is so cool she makes wintertime Toronto seem tropical. " + 
				"With soft features, keen eyes and dyed hair that recall Kate Winslet in “Eternal Sunshine of the Spotless Mind,” Ms. Winstead is both the film’s designated heartthrob and its brains. The pairing of an " + 
				"anxious, diffident loser with a woman who is miles out of his league is beyond a cliché at this point, and making the situation seem fresh is a task that falls on Ms. Winstead as much as on Mr. Cera. And " + 
				"somehow they make it work, in part because Ramona never lets go of her skepticism even as she warms to Scott, and in part because Scott is never the abject weakling he often wants everyone to believe he is. " + 
				"His quivery diffidence contains quite a bit of guile, and what we know of his romantic history suggests a wolf in wet noodle’s clothing. (At least one young woman, a truculent barista named Julie, played by Aubrey Plaza, has his number on this score) " + 
				"Ramona’s romantic history, on the other hand, poses a mortal danger to Scott. One of her exes (it turns out to be Jason Schwartzman, amusingly cast as the designated older guy) has organized the others, going back to grade school, " + 
				"into a league, and Scott must do battle with each one in turn. The fights are as much like musical numbers as standard action sequences, and they give Mr. Wright the chance to expand the kinetic visual wit that made his earlier genre spoofs " + 
				"— “Shaun of the Dead” and “Hot Fuzz”— such crazy fun.", comics, movies, music);
			scottPilgrim = reviewRepo.save(scottPilgrim);
		
	}
	
	

}
