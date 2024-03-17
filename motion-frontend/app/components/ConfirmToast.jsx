import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

export default function ConfirmToast({ actionFunc }) {
    const notify = () => {
        toast.success('Ticket solved successfully', {
            position: "top-center",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
            transition: 'Bounce',
        });
        actionFunc();
    }

    return (
      <div>
        <button onClick={notify}>Solve</button>
        <ToastContainer />
      </div>
    );
}