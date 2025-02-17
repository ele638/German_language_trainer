import SwiftUI

@main
struct iOSApp: App {
    init() {
        KoinApp().initKoin()
    }
	var body: some Scene {
	    KoinApp().initKoin()
		WindowGroup {
			ContentView()
		}
	}
}