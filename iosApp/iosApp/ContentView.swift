import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ContentView.ViewModel

    var body: some View {
        ListView(phrases: viewModel.grettings).task { await self.viewModel.startObserving }
    }
}
extension ContentView {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var greetings: Array<String> = []

        func startObserving() async {
            for await phrase in Greeting().greet() {
                self.greetings.append(phrase)
            }
        }
    }
}

struct ListView: View {
    let phrases: Array<String>
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