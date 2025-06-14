import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().flightResponse()
    let phrases = Greeting().greetingList()

    var body: some View {
        List(phrases, id: \.self) {
            Text($0)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}