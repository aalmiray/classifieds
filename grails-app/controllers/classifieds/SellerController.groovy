package classifieds

class SellerController {
    static defaultAction = 'signup'

    def signup() {
        [bean: new SignupCommand()]
    }

    def subscribe(SignupCommand command) {
        if (command.hasErrors()) {
            render(view: 'signup', model: [bean: command])
            return
        }

        Seller seller = new Seller(params)

        if (!seller.save(flush: true)) {
            flash.message = "Ooops"
            render(view: 'signup', model: [bean: seller])
            return
        }
        
        // email confirmation goes here!!
        
        [command: command]
    }
}

class SignupCommand {
    String name
    String email
    Address address

    static constraints = {
        name(nullable: false, blank: false)
        email(nullable: false, blank: false, email: true)
    }
}