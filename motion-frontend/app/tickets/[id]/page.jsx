"use client"

import { notFound } from "next/navigation";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

export const dynamicParams = true;

async function getTicketById(id) {
    try {
        const res = await fetch(`http://localhost:8080/api/v1/tickets/${id}`, {
            next: {
                revalidate: 0
            }
        });
        return res.json();
    } catch (err) {
        notFound();
    }
}


export default async function TicketDetails({ params }) {
    const id = params.id;
    const router = useRouter();
    const [isConfirmed, setIsConfirmed] = useState(true);

    const ticket = await getTicketById(id);

    if (ticket === null) {
        notFound();
    }

    const confirm = () => toast.success('Ticket solved successfully!', {
        position: "top-center",
        autoClose: 2000,
        theme: 'colored'
    });
    

    const handleDelete = async() => {
        
        const ticket = {id};
        const res = await fetch("http://localhost:8080/api/v1/tickets", {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(ticket)
        });
        confirm();
        setTimeout(() => {
            if (res.status == 200) {
                router.push("/tickets");
                router.refresh();
            }
        }, 2000);
    }

    return (
        <main>
            <nav>
                <h2>Ticket Details</h2>
            </nav>
            <div className="card">
                <div className="header">
                    <div>
                        <h3>{ticket.title}</h3>
                        <small>Created by {ticket.userEmail}</small>
                    </div>
                    <div>
                        {
                            isConfirmed? 
                                <button className="btn-primary" onClick={() => {setIsConfirmed(false)}}>Solved</button> : 
                                <button className="btn-primary" onClick={handleDelete}>Confirm</button>
                        }
                        <ToastContainer/>
                    </div>
                </div>
                <p>{ticket.body}</p>
                <div className={`pill ${ticket.priority}`}>
                    {ticket.priority} priority
                </div>
            </div>
            
        </main>
    )
}