import TicketList from "./TicketList";
import Link from "next/link";

export default function Tickets() {
    return (
        <main>
            <nav className="ticket-nav">
                <div>
                    <h2>Tickets</h2>
                    <p><small>Currently open tickets</small></p>
                </div>
                <Link href="/tickets/create">
                    <button className="btn-primary">Add</button>
                </Link>
            </nav>
            <TicketList />
        </main>
    );
}