import Image from "next/image";
import Link from "next/link";
import Logo from '@/public/logo.png'

export default function NavBar() {
    return (
        <nav>
            <Image
                src={Logo}
                width={70}
                quality={100}
            />
            <Link href="/"><h1>Motion Support</h1></Link>
            <div>
                <Link href="/news">News</Link>
            </div>
        </nav>
    );
}