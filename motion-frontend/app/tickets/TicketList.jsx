import Link from "next/link";
import { notFound } from "next/navigation";

async function getTickets() {
    try {
        const res = await fetch('http://localhost:8080/api/v1/tickets', {
            next: {
                revalidate: 0
            }
        });
        return res.json();
    } catch(e) {
        notFound();
    }
}

export default async function TicketList() {
    const tickets = await getTickets();

    if (tickets === null) {
        notFound();
    }

    return (
        <div>
            {
                tickets.map((ticket) => {
                    return (
                        <div key={ticket.id} className="card">
                            <div className={'title-wrapper'}>
                                <h3>{ticket.title}</h3>
                                <Link href={`/tickets/${ticket.id}`}>
                                    <p><small>More details {'>'}</small></p>
                                </Link>
                            </div>
                            <p>{ticket.body.slice(0,200)}...</p>
                            <div className={`pill ${ticket.priority}`}>
                                {ticket.priority} priority
                            </div>
                        </div>
                    )
                })
            }
            {
                tickets.length === 0 && (
                    <p className="text-center">
                        There are no open tickets, YAY!
                    </p>
                )
            }
        </div>
    )
}